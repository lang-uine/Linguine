package com.Linguine.domain.member;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Embeddable
@AllArgsConstructor
@ToString
public class Lock{
    @NotNull
    @Setter
    private boolean locked;
    @Nullable
    private LocalDateTime period;

    private int count;

    public void countUp() {
        this.count += 1;
    }

    public Lock() {
        this.locked = false;
        this.count = 0;
    }

    public boolean isLocked() {
        return locked;
    }

    public void suspend() {
        this.locked = true;
        this.countUp();
        if (this.count == 1) {
            this.period = LocalDateTime.now().plusDays(3);
        } else if (this.count == 2) {
            this.period = LocalDateTime.now().plusDays(7);
        }else{
            this.period = LocalDateTime.now().plusDays(30);
        }
    }

}
