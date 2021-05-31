package com.concurrent.demo15Lambda;

/**
 * lambda
 * @author lane
 * @date 2021年05月26日 下午11:21
 */
public class TestLambdaDemo {

    public static void main(String[] args) {

        //会出错，没有上下文，推断不出来
        // ()->{ System.out.println("aa");};
        //匿名内部类
        TestLambda testLambda = new TestLambda() {
            @Override
            public void test(String aa) {
                System.out.println("test方法执行了");
            }
        };

        testLambda.test("hello");
        //必须只有一个抽象方法才行，接口中如果有两个方法就会编译出错了
        //lambda
        TestLambda testLambda1 = ((aa) -> {
            System.out.println("lambda的test方法执行了");
        });
        testLambda1.test("hello");

/*      lambda表达式的省略（不建议看）
        1. () 中的参数类型声明可以省略掉，可以推断出来
        2. () 中如果只有一个参数，小括号可以省略
        3. {} 号中如果只有一行不是返回值的代码，大括号可以省略，分号也可以省略（必须分号和大括号同时省略）
        4. {} 当只有一行返回值的时候，在大括号和分号同时省略的基础上，return 也可以省略
*/
        //0lambda的标准样式
        TestLambdaOmit testLambdaOmit0 = (String aa, String bb) -> {
            System.out.println("0lambda的标准样式");
            return aa + bb;
        };
        //1lambda参数类型声省略掉
        TestLambdaOmit testLambdaOmit1 = (aa, bb) -> {
            System.out.println("1lambda参数类型声省略掉");
            return aa + bb;
        };
        //2()中如果只有一个参数，小括号可以省略
        TestLambda testLambda2 = (aa -> {
            System.out.println("2()中如果只有一个参数，小括号可以省略");
        });
        //3{} 号中如果只有一行代码，大括号可以省略，分号也可以省略
        TestLambda testLambda3 = (aa -> System.out.println("3{} 号中如果只有一行代码，大括号可以省略，分号也可以省略"));
        //4{}当只有一行返回值的时候，在大括号和分号同时省略的基础上，return 也可以省略
        TestLambdaOmit testLambdaOmit4 = (aa, bb) ->  aa + bb;
           // System.out.println("4{}当只有一行返回值的时候在大括号和分号同时省略的基础上，return 也可以省略");

        //0
        System.out.println("========下面是测试省略============");
        System.out.println(testLambdaOmit0.testOmit("hello", "world"));
        //1
        System.out.println(testLambdaOmit1.testOmit("hello", "world"));
        //2
        testLambda2.test("hello");
        //3
        testLambda3.test("hello");
        //4
        System.out.println(testLambdaOmit4.testOmit("hello", "world"));
    }
}

