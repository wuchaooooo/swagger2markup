#!/bin/bash
mvn clean compile -Dmaven.test.skip
mvn asciidoctor:process-asciidoc@output-html