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

/** This is an auto generated class representing the Student type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Students", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Student implements Model {
  public static final QueryField ID = field("Student", "id");
  public static final QueryField NAME = field("Student", "name");
  public static final QueryField YEAR = field("Student", "year");
  public static final QueryField IS_MALE = field("Student", "isMale");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="Int", isRequired = true) Integer year;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean isMale;
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
  
  public Integer getYear() {
      return year;
  }
  
  public Boolean getIsMale() {
      return isMale;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Student(String id, String name, Integer year, Boolean isMale) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.isMale = isMale;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Student student = (Student) obj;
      return ObjectsCompat.equals(getId(), student.getId()) &&
              ObjectsCompat.equals(getName(), student.getName()) &&
              ObjectsCompat.equals(getYear(), student.getYear()) &&
              ObjectsCompat.equals(getIsMale(), student.getIsMale()) &&
              ObjectsCompat.equals(getCreatedAt(), student.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), student.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getYear())
      .append(getIsMale())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Student {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("year=" + String.valueOf(getYear()) + ", ")
      .append("isMale=" + String.valueOf(getIsMale()) + ", ")
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
  public static Student justId(String id) {
    return new Student(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      year,
      isMale);
  }
  public interface NameStep {
    YearStep name(String name);
  }
  

  public interface YearStep {
    IsMaleStep year(Integer year);
  }
  

  public interface IsMaleStep {
    BuildStep isMale(Boolean isMale);
  }
  

  public interface BuildStep {
    Student build();
    BuildStep id(String id);
  }
  

  public static class Builder implements NameStep, YearStep, IsMaleStep, BuildStep {
    private String id;
    private String name;
    private Integer year;
    private Boolean isMale;
    public Builder() {
      
    }
    
    private Builder(String id, String name, Integer year, Boolean isMale) {
      this.id = id;
      this.name = name;
      this.year = year;
      this.isMale = isMale;
    }
    
    @Override
     public Student build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Student(
          id,
          name,
          year,
          isMale);
    }
    
    @Override
     public YearStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public IsMaleStep year(Integer year) {
        Objects.requireNonNull(year);
        this.year = year;
        return this;
    }
    
    @Override
     public BuildStep isMale(Boolean isMale) {
        Objects.requireNonNull(isMale);
        this.isMale = isMale;
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
    private CopyOfBuilder(String id, String name, Integer year, Boolean isMale) {
      super(id, name, year, isMale);
      Objects.requireNonNull(name);
      Objects.requireNonNull(year);
      Objects.requireNonNull(isMale);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder year(Integer year) {
      return (CopyOfBuilder) super.year(year);
    }
    
    @Override
     public CopyOfBuilder isMale(Boolean isMale) {
      return (CopyOfBuilder) super.isMale(isMale);
    }
  }
  

  public static class StudentIdentifier extends ModelIdentifier<Student> {
    private static final long serialVersionUID = 1L;
    public StudentIdentifier(String id) {
      super(id);
    }
  }
  
}
