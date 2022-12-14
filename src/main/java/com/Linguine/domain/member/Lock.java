package com.Linguine.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Embeddable
@AllArgsConstructor
public class Lock{
    @NotNull
    private boolean locked;
    @Nullable
    private LocalDateTime period;

    public Lock() {
        this.locked = false;
    }
}
