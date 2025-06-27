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

/** This is an auto generated class representing the Barcodes type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Barcodes", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Barcodes implements Model {
  public static final QueryField ID = field("Barcodes", "id");
  public static final QueryField STUDENT_ID = field("Barcodes", "studentID");
  public static final QueryField EXAM = field("Barcodes", "exam");
  public static final QueryField BARCODE = field("Barcodes", "barcode");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String studentID;
  private final @ModelField(targetType="String") String exam;
  private final @ModelField(targetType="String") String barcode;
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
  
  public String getStudentId() {
      return studentID;
  }
  
  public String getExam() {
      return exam;
  }
  
  public String getBarcode() {
      return barcode;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Barcodes(String id, String studentID, String exam, String barcode) {
    this.id = id;
    this.studentID = studentID;
    this.exam = exam;
    this.barcode = barcode;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Barcodes barcodes = (Barcodes) obj;
      return ObjectsCompat.equals(getId(), barcodes.getId()) &&
              ObjectsCompat.equals(getStudentId(), barcodes.getStudentId()) &&
              ObjectsCompat.equals(getExam(), barcodes.getExam()) &&
              ObjectsCompat.equals(getBarcode(), barcodes.getBarcode()) &&
              ObjectsCompat.equals(getCreatedAt(), barcodes.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), barcodes.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getStudentId())
      .append(getExam())
      .append(getBarcode())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Barcodes {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("studentID=" + String.valueOf(getStudentId()) + ", ")
      .append("exam=" + String.valueOf(getExam()) + ", ")
      .append("barcode=" + String.valueOf(getBarcode()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
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
  public static Barcodes justId(String id) {
    return new Barcodes(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      studentID,
      exam,
      barcode);
  }
  public interface BuildStep {
    Barcodes build();
    BuildStep id(String id);
    BuildStep studentId(String studentId);
    BuildStep exam(String exam);
    BuildStep barcode(String barcode);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String studentID;
    private String exam;
    private String barcode;
    public Builder() {
      
    }
    
    private Builder(String id, String studentID, String exam, String barcode) {
      this.id = id;
      this.studentID = studentID;
      this.exam = exam;
      this.barcode = barcode;
    }
    
    @Override
     public Barcodes build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Barcodes(
          id,
          studentID,
          exam,
          barcode);
    }
    
    @Override
     public BuildStep studentId(String studentId) {
        this.studentID = studentId;
        return this;
    }
    
    @Override
     public BuildStep exam(String exam) {
        this.exam = exam;
        return this;
    }
    
    @Override
     public BuildStep barcode(String barcode) {
        this.barcode = barcode;
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
    private CopyOfBuilder(String id, String studentId, String exam, String barcode) {
      super(id, studentID, exam, barcode);
      
    }
    
    @Override
     public CopyOfBuilder studentId(String studentId) {
      return (CopyOfBuilder) super.studentId(studentId);
    }
    
    @Override
     public CopyOfBuilder exam(String exam) {
      return (CopyOfBuilder) super.exam(exam);
    }
    
    @Override
     public CopyOfBuilder barcode(String barcode) {
      return (CopyOfBuilder) super.barcode(barcode);
    }
  }
  

  public static class BarcodesIdentifier extends ModelIdentifier<Barcodes> {
    private static final long serialVersionUID = 1L;
    public BarcodesIdentifier(String id) {
      super(id);
    }
  }
  
}
