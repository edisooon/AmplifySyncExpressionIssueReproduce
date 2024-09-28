package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.ModelIdentifier;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the PostEditor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "PostEditors", type = Model.Type.USER, version = 1)
@Index(name = "byPost", fields = {"postId"})
@Index(name = "byUser", fields = {"userId"})
public final class PostEditor implements Model {
  public static final QueryField ID = field("PostEditor", "id");
  public static final QueryField POST = field("PostEditor", "postId");
  public static final QueryField USER = field("PostEditor", "userId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Post", isRequired = true) @BelongsTo(targetName = "postId", targetNames = {"postId"}, type = Post.class) Post post;
  private final @ModelField(targetType="User", isRequired = true) @BelongsTo(targetName = "userId", targetNames = {"userId"}, type = User.class) User user;
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
  
  public Post getPost() {
      return post;
  }
  
  public User getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private PostEditor(String id, Post post, User user) {
    this.id = id;
    this.post = post;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      PostEditor postEditor = (PostEditor) obj;
      return ObjectsCompat.equals(getId(), postEditor.getId()) &&
              ObjectsCompat.equals(getPost(), postEditor.getPost()) &&
              ObjectsCompat.equals(getUser(), postEditor.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), postEditor.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), postEditor.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPost())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("PostEditor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("post=" + String.valueOf(getPost()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static PostStep builder() {
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
  public static PostEditor justId(String id) {
    return new PostEditor(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      post,
      user);
  }
  public interface PostStep {
    UserStep post(Post post);
  }
  

  public interface UserStep {
    BuildStep user(User user);
  }
  

  public interface BuildStep {
    PostEditor build();
    BuildStep id(String id);
  }
  

  public static class Builder implements PostStep, UserStep, BuildStep {
    private String id;
    private Post post;
    private User user;
    public Builder() {
      
    }
    
    private Builder(String id, Post post, User user) {
      this.id = id;
      this.post = post;
      this.user = user;
    }
    
    @Override
     public PostEditor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new PostEditor(
          id,
          post,
          user);
    }
    
    @Override
     public UserStep post(Post post) {
        Objects.requireNonNull(post);
        this.post = post;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        Objects.requireNonNull(user);
        this.user = user;
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
    private CopyOfBuilder(String id, Post post, User user) {
      super(id, post, user);
      Objects.requireNonNull(post);
      Objects.requireNonNull(user);
    }
    
    @Override
     public CopyOfBuilder post(Post post) {
      return (CopyOfBuilder) super.post(post);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  

  public static class PostEditorIdentifier extends ModelIdentifier<PostEditor> {
    private static final long serialVersionUID = 1L;
    public PostEditorIdentifier(String id) {
      super(id);
    }
  }
  
}
