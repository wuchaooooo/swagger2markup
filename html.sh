#!/bin/bash
rm -rf ./asciidoc/*
mvn clean compile -Dmaven.test.skip
mvn asciidoctor:process-asciidoc@output-html