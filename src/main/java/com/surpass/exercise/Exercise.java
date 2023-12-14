package com.surpass.exercise;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "exercises")

public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "string_id")
    @NotNull(message = "stringId shall not be null")
    @NotBlank(message = "stringId shall not be blank")
    private String stringId;

    @Column(name = "body_part")
    @NotNull(message = "body_part shall not be null")
    @NotBlank(message = "body_part shall not be blank")
    private String bodyPart;

    @Column(name = "weight_connection")
    @NotNull(message = "weight_connection shall not be null")
    @NotBlank(message = "weight_connection shall not be blank")
    private String weightConnection;

    @Column
    @NotNull(message = "type shall not be null")
    @NotBlank(message = "type shall not be blank")
    private String type;

    @Column
    @NotNull(message = "name shall not be null")
    @NotBlank(message = "name shall not be blank")
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Exercise() {
    }

    public Long getId() {
        return this.id;
    }

    public String getStringId() {
        return this.stringId;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public String getWeightConnection() {
        return this.weightConnection;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public void setWeightConnection(String weightConnection) {
        this.weightConnection = weightConnection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Exercise)) return false;
        final Exercise other = (Exercise) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$stringId = this.getStringId();
        final Object other$stringId = other.getStringId();
        if (this$stringId == null ? other$stringId != null : !this$stringId.equals(other$stringId)) return false;
        final Object this$bodyPart = this.getBodyPart();
        final Object other$bodyPart = other.getBodyPart();
        if (this$bodyPart == null ? other$bodyPart != null : !this$bodyPart.equals(other$bodyPart)) return false;
        final Object this$weightConnection = this.getWeightConnection();
        final Object other$weightConnection = other.getWeightConnection();
        if (this$weightConnection == null ? other$weightConnection != null : !this$weightConnection.equals(other$weightConnection))
            return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Exercise;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $stringId = this.getStringId();
        result = result * PRIME + ($stringId == null ? 43 : $stringId.hashCode());
        final Object $bodyPart = this.getBodyPart();
        result = result * PRIME + ($bodyPart == null ? 43 : $bodyPart.hashCode());
        final Object $weightConnection = this.getWeightConnection();
        result = result * PRIME + ($weightConnection == null ? 43 : $weightConnection.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    public String toString() {
        return "Exercise(id=" + this.getId() + ", stringId=" + this.getStringId() + ", bodyPart=" + this.getBodyPart() + ", weightConnection=" + this.getWeightConnection() + ", type=" + this.getType() + ", name=" + this.getName() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
