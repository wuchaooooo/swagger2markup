package com.wuchaooooo.service.swagger2markup;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class GenerateApiDoc implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        Path localSwaggerFile = Paths.get("src/main/resources/swagger/wanda/sail/member/card/card-api_2017-11-23_2.yaml");
        Path outputFile = Paths.get("build/card-api_2017-11-23_2");
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(localSwaggerFile)
                .withConfig(config)
                .build();
        converter.toFile(outputFile);
    }
}
