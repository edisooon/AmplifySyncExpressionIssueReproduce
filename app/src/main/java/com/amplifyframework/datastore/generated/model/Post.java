package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Post type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Posts", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Post implements Model {
  public static final QueryField ID = field("Post", "id");
  public static final QueryField TITLE = field("Post", "title");
  public static final QueryField STATUS = field("Post", "status");
  public static final QueryField RATING = field("Post", "rating");
  public static final QueryField CONTENT = field("Post", "content");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="PostStatus", isRequired = true) PostStatus status;
  private final @ModelField(targetType="Int") Integer rating;
  private final @ModelField(targetType="String") String content;
  private final @ModelField(targetType="Comment") @HasMany(associatedWith = "post", type = Comment.class) List<Comment> comments = null;
  private final @ModelField(targetType="PostEditor") @HasMany(associatedWith = "post", type = PostEditor.class) List<PostEditor> editors = null;
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
  
  public String getTitle() {
      return title;
  }
  
  public PostStatus getStatus() {
      return status;
  }
  
  public Integer getRating() {
      return rating;
  }
  
  public String getContent() {
      return content;
  }
  
  public List<Comment> getComments() {
      return comments;
  }
  
  public List<PostEditor> getEditors() {
      return editors;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Post(String id, String title, PostStatus status, Integer rating, String content) {
    this.id = id;
    this.title = title;
    this.status = status;
    this.rating = rating;
    this.content = content;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Post post = (Post) obj;
      return ObjectsCompat.equals(getId(), post.getId()) &&
              ObjectsCompat.equals(getTitle(), post.getTitle()) &&
              ObjectsCompat.equals(getStatus(), post.getStatus()) &&
              ObjectsCompat.equals(getRating(), post.getRating()) &&
              ObjectsCompat.equals(getContent(), post.getContent()) &&
              ObjectsCompat.equals(getCreatedAt(), post.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), post.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTitle())
      .append(getStatus())
      .append(getRating())
      .append(getContent())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Post {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("rating=" + String.valueOf(getRating()) + ", ")
      .append("content=" + String.valueOf(getContent()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static TitleStep builder() {
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
  public static Post justId(String id) {
    return new Post(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      title,
      status,
      rating,
      content);
  }
  public interface TitleStep {
    StatusStep title(String title);
  }
  

  public interface StatusStep {
    BuildStep status(PostStatus status);
  }
  

  public interface BuildStep {
    Post build();
    BuildStep id(String id);
    BuildStep rating(Integer rating);
    BuildStep content(String content);
  }
  

  public static class Builder implements TitleStep, StatusStep, BuildStep {
    private String id;
    private String title;
    private PostStatus status;
    private Integer rating;
    private String content;
    public Builder() {
      
    }
    
    private Builder(String id, String title, PostStatus status, Integer rating, String content) {
      this.id = id;
      this.title = title;
      this.status = status;
      this.rating = rating;
      this.content = content;
    }
    
    @Override
     public Post build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Post(
          id,
          title,
          status,
          rating,
          content);
    }
    
    @Override
     public StatusStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public BuildStep status(PostStatus status) {
        Objects.requireNonNull(status);
        this.status = status;
        return this;
    }
    
    @Override
     public BuildStep rating(Integer rating) {
        this.rating = rating;
        return this;
    }
    
    @Override
     public BuildStep content(String content) {
        this.content = content;
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
    private CopyOfBuilder(String id, String title, PostStatus status, Integer rating, String content) {
      super(id, title, status, rating, content);
      Objects.requireNonNull(title);
      Objects.requireNonNull(status);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder status(PostStatus status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder rating(Integer rating) {
      return (CopyOfBuilder) super.rating(rating);
    }
    
    @Override
     public CopyOfBuilder content(String content) {
      return (CopyOfBuilder) super.content(content);
    }
  }
  

  public static class PostIdentifier extends ModelIdentifier<Post> {
    private static final long serialVersionUID = 1L;
    public PostIdentifier(String id) {
      super(id);
    }
  }
  
}
