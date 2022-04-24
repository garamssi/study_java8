package com.example.me_garamssi.basicInterfaceAndStaticMethod;

public interface Foo {

        void printName();

//        void printNameUpperCase();
        /**
         * 1. interface에서 메소드를 하나 추가할 때 해당 인터페이스를 상속 받는 클래스들에 에러가 나지만
         * default 키워드로 적용하게 되면 인스턴스에서 오버라이딩하지 않고 바로 사용 할 수 있다.
         *
         * 2. 상속 받은 인스턴스에서 오버라이딩 따로 가능하다.
         *
         * 3. Object의 일부 메소드들은 default로 재정의 할 수 없다.
         *
         * 4. 내가 만든 인터페이스만 default를 정의할 수 있고 이미 만들어져서 제공하고 있는 lib에서는 default 사용이 불가능하다.
         *
         * 5. 두개의 인터페이스에서 같은 메소드 명의 default 메소드가 있다면 충돌이나서 컴파일 에러가 난다.
         * 그럴 때는 상속받고 있는 인스턴스에서 오버라이딩으로 재정의를 해줘야한다.
         * */


        /**
         * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
         * */
        default void printNameUpperCase() {
                System.out.println(getName().toUpperCase());
        };

        /**
         * static 메소드를 사용하면 인스턴스에 따로 오버라이딩 하지 않고 전역적으로 사용할 수 있다.
         * */

        static void printAnything(){
                System.out.println("static method");
        }

        public String getName();

}
