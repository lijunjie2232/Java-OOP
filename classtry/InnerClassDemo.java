class OuterClass {
    private String msg = "OUTER MSG";

    public void test() {
        InnerClass ic = new InnerClass();
        ic.test();
        System.out.println("OUTER CLASS: " + ic.msg);
    }

    class InnerClass {
        private String msg = "INNER MSG";

        public void test() {
            InnerInnerClass iic = new InnerInnerClass();
            iic.test();
            System.out.println("INNER CLASS: " + iic.msg);
        }

        class InnerInnerClass {
            private String msg = "INNER INNER MSG";

            public void test(){
                InnerInnerClass iinc = new InnerInnerClass(){
                    private String msg = "INNER INNER ANONYMOUS MSG";
                    public void test(){
                        System.out.println("INNERINNERANONY CLASS: " + OuterClass.this.msg);
                        System.out.println("INNERINNERANONY CLASS: " + InnerClass.this.msg);
                        System.out.println("INNERINNERANONY CLASS: " + InnerInnerClass.this.msg);
                    }
                };
                System.out.println("INNERINNER CLASS: " + OuterClass.this.msg);
                System.out.println("INNERINNER CLASS: " + InnerClass.this.msg);
                iinc.test();
                System.out.println("INNERINNER CLASS: " + iinc.msg);
            }
        }
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.test();
        System.out.println("********");
        OuterClass.InnerClass.InnerInnerClass iic = new OuterClass().new InnerClass().new InnerInnerClass();
        iic.test();
    }
}
