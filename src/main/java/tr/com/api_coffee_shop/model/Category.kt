package tr.com.api_coffee_shop.model

import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import tr.com.api_coffee_shop.dto.LocalizedTextDTO

@Document(collection = "categories")
data class Category(
        @Id
        var id: String? = null,

        @Field("parent_cat")
        var parentCatId: String? = null,

        @NotNull(message = "Category name must not be null")
        var name: LocalizedTextDTO? = null
)