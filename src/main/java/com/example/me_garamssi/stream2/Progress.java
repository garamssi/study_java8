package com.example.me_garamssi.stream2;

import java.time.Duration;

public class Progress {

        private Duration studyDuration;

        private boolean finished;

        public Duration getStudyDuration(){
                return studyDuration;
        }

        public void setStudyDuration(Duration studyDuration) {
                this.studyDuration = studyDuration;
        }
}
