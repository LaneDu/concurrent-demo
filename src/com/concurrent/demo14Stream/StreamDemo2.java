package com.concurrent.demo14Stream;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 匿名内部类的延时执行特性
 * @author lane
 * @date 2021年05月27日 上午12:47
 */
public class StreamDemo2 {

    public static void main(String[] args) {

        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println("1执行了test方法了,参数为"+s);
                return s.endsWith("d");
            }
        };
        Predicate<String> predicate2 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println("2执行了test方法了,参数为"+s);
                return s.startsWith("h");
            }
        };

        mymethod(predicate1,predicate2);


    }

    public static void mymethod(Predicate<String> pre1,Predicate<String> pre2){
        //1
        pre1.and(pre2);
        //2
        new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println("执行了test方法了,参数为"+s);
                return s.startsWith("h") && s.endsWith("d");
            }
        };
        //看源码得知1等价于2,这样执行并不会打印任何信息
        //而stream流的创建和过滤,只是拼接条件并没有执行具体方法 依据匿名内部类的延时执行现象
        //多个拼接的方法并凝眸没有执行,类似于stream流式多个过滤方法
        //调用test方法就类似于stream流的终结方法，这时候才会执行所有的方法
        //list.stream().filter(s->s.startsWith("h")).filter(s->s.endsWith("d")).foreach((s)->System.out.println("执行了test方法了,参数为"+s);)
        pre1.and(pre2).test("helloworld");//这就是流的原理一种表现形式
        //打印内容为
        //1执行了test方法了,参数为helloworld
        //2执行了test方法了,参数为helloworld



        //源码
        /*default Predicate<T> and(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return (t) -> test(t) && other.test(t);
        }*/
    }


}
