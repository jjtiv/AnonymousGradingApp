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

/** This is an auto generated class representing the ClassRoster type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ClassRosters", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class ClassRoster implements Model {
  public static final QueryField ID = field("ClassRoster", "id");
  public static final QueryField STUDENT_ID = field("ClassRoster", "studentID");
  public static final QueryField STUDENT_NAME = field("ClassRoster", "studentName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String studentID;
  private final @ModelField(targetType="String") String studentName;
  /** @deprecated This API is internal to Amplify and should not be used. */
  @Deprecated
   public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getStudentId() {
      return studentID;
  }
  
  public String getStudentName() {
      return studentName;
  }

  
  private ClassRoster(String id, String studentID, String studentName) {
    this.id = id;
    this.studentID = studentID;
    this.studentName = studentName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ClassRoster classRoster = (ClassRoster) obj;
      return ObjectsCompat.equals(getId(), classRoster.getId()) &&
              ObjectsCompat.equals(getStudentId(), classRoster.getStudentId()) &&
              ObjectsCompat.equals(getStudentName(), classRoster.getStudentName());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getStudentId())
      .append(getStudentName())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ClassRoster {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("studentID=" + String.valueOf(getStudentId()) + ", ")
      .append("studentName=" + String.valueOf(getStudentName()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
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
  public static ClassRoster justId(String id) {
    return new ClassRoster(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      studentID,
      studentName);
  }
  public interface BuildStep {
    ClassRoster build();
    BuildStep id(String id);
    BuildStep studentId(String studentId);
    BuildStep studentName(String studentName);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String studentID;
    private String studentName;
    public Builder() {
      
    }
    
    private Builder(String id, String studentID, String studentName) {
      this.id = id;
      this.studentID = studentID;
      this.studentName = studentName;
    }
    
    @Override
     public ClassRoster build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ClassRoster(
          id,
          studentID,
          studentName);
    }
    
    @Override
     public BuildStep studentId(String studentId) {
        this.studentID = studentId;
        return this;
    }
    
    @Override
     public BuildStep studentName(String studentName) {
        this.studentName = studentName;
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
    private CopyOfBuilder(String id, String studentId, String studentName) {
      super(id, studentID, studentName);
      
    }
    
    @Override
     public CopyOfBuilder studentId(String studentId) {
      return (CopyOfBuilder) super.studentId(studentId);
    }
    
    @Override
     public CopyOfBuilder studentName(String studentName) {
      return (CopyOfBuilder) super.studentName(studentName);
    }
  }
  

  public static class ClassRosterIdentifier extends ModelIdentifier<ClassRoster> {
    private static final long serialVersionUID = 1L;
    public ClassRosterIdentifier(String id) {
      super(id);
    }
  }
  
}
