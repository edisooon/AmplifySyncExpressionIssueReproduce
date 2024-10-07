package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Test2 type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Test2s", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Test2 implements Model {
  public static final QueryField ID = field("Test2", "id");
  public static final QueryField NAME = field("Test2", "name");
  public static final QueryField NUMBER = field("Test2", "number");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="Int", isRequired = true) Integer number;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public Integer getNumber() {
      return number;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Test2(String id, String name, Integer number) {
    this.id = id;
    this.name = name;
    this.number = number;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Test2 test2 = (Test2) obj;
      return ObjectsCompat.equals(getId(), test2.getId()) &&
              ObjectsCompat.equals(getName(), test2.getName()) &&
              ObjectsCompat.equals(getNumber(), test2.getNumber()) &&
              ObjectsCompat.equals(getCreatedAt(), test2.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), test2.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getNumber())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Test2 {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("number=" + String.valueOf(getNumber()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Test2 justId(String id) {
    return new Test2(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      number);
  }
  public interface NameStep {
    NumberStep name(String name);
  }
  

  public interface NumberStep {
    BuildStep number(Integer number);
  }
  

  public interface BuildStep {
    Test2 build();
    BuildStep id(String id);
  }
  

  public static class Builder implements NameStep, NumberStep, BuildStep {
    private String id;
    private String name;
    private Integer number;
    public Builder() {
      
    }
    
    private Builder(String id, String name, Integer number) {
      this.id = id;
      this.name = name;
      this.number = number;
    }
    
    @Override
     public Test2 build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Test2(
          id,
          name,
          number);
    }
    
    @Override
     public NumberStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep number(Integer number) {
        Objects.requireNonNull(number);
        this.number = number;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, Integer number) {
      super(id, name, number);
      Objects.requireNonNull(name);
      Objects.requireNonNull(number);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder number(Integer number) {
      return (CopyOfBuilder) super.number(number);
    }
  }
  

  public static class Test2Identifier extends ModelIdentifier<Test2> {
    private static final long serialVersionUID = 1L;
    public Test2Identifier(String id) {
      super(id);
    }
  }
  
}
