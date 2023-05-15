package com.example.searchService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "chat")
public class Entity {

    @Id
    private String id;

    @Field(type = FieldType.Nested, includeInParent = true)
    private String userName;

    @Field(type = FieldType.Nested, includeInParent = true)
    private String chatText;

}
