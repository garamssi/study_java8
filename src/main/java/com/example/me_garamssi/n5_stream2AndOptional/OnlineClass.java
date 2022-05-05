package com.example.me_garamssi.n5_stream2AndOptional;

import java.util.Optional;

public class OnlineClass {

        private Integer id;
        private String title;
        private boolean closed;
        private Progress progress;

        public OnlineClass(Integer id, String title, boolean closed) {
                this.id = id;
                this.title = title;
                this.closed = closed;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public boolean isClosed() {
                return closed;
        }

        public void setClosed(boolean closed) {
                this.closed = closed;
        }

        /**
         * Optional은 리턴 타입으로 쓰는 것이 권장 사항이다.
         * Optional은 null을 포함 할 수 있기 때문에 오히려 NullPointException을 피하기 위해 번거로운 코드가 될 수 있다.
         * 매개변수 타입, 맵의 키, 필드타입 사용 x
         *
         * null을 return 하지말고 Optional.empty()를 리턴하자.
         * */
        public Optional<Progress> getProgress() {
                return Optional.ofNullable(progress);
//                return Optional.of(progress); 무조건 null이 아닌 경우 사용
        }

        public void setProgress(Progress progress) {
                this.progress = progress;
        }
}
