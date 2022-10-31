package com.example.effectivejava.item02.hierarchicalbuilder;

import java.util.Objects;

// 코드 2-5 뉴욕 피자 - 계층적 빌더를 활용한 하위 클래스
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) { this.size = Objects.requireNonNull(size);}

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }


}
