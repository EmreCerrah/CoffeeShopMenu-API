package tr.com.api_labianco.model

import jakarta.validation.constraints.NotNull
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field
import tr.com.api_labianco.dto.LocalizedTextDTO

@Document(collection = "product", language = "tr")
data class Product(
        @Id
        var id: String? = null,

        @NotNull(message = "Product tier must not be null")
        var tier: Int = 0,

        @Indexed
        @Field("categories_id")
        @NotNull(message = "Category id must not be null")
        var categoriesId: String? = null,

        @NotNull(message = "Product price must not be null")
        var price: Int = 0,

        @NotNull(message = "Product name must not be null")
        var name: LocalizedTextDTO? = null,

        var detail: LocalizedTextDTO? = null // Detail in multiple languages
)
