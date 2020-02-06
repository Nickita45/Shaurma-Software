package com.orders.management.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LineAdditive {

    @EmbeddedId
    LineAdditiveKey id;

    @ManyToOne
    @MapsId("line_id")
    @JoinColumn(name = "line_id")
    Line line;

    @ManyToOne
    @MapsId("additive_id")
    @JoinColumn(name = "additive_id")
    Additive additive;

}
