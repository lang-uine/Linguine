package com.Linguine.domain.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("free")
public class FreePost extends Post{
}
