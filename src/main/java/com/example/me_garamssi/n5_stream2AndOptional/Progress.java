package com.example.me_garamssi.n5_stream2AndOptional;

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
