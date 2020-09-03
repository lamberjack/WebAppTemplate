package model.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class AbstractEntity {

    public static final String MANDATORY_ATTRIBUTE_MESSAGE = " is mandatory.";

    @Column(name = "uuid", unique = true)
    @NotNull(message = "UUID" + MANDATORY_ATTRIBUTE_MESSAGE)
    private final String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }
}
