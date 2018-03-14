#!/usr/bin/env bash
function copyEnvVarsToGradleProperties {
    GRADLE_PROPERTIES=$HOME"/.gradle/gradle.properties"
    export GRADLE_PROPERTIES
    echo "Gradle Properties should exist at $GRADLE_PROPERTIES"

    if [ ! -f "$GRADLE_PROPERTIES" ]; then
        echo "Gradle Properties does not exist"

        echo "Creating Gradle Properties file..."
        touch $GRADLE_PROPERTIES

        echo "Writing API_KEY to gradle.properties..."
        echo "THEMOVIEDB_API_KEY=$THEMOVIEDB_API_KEY" >> $GRADLE_PROPERTIES
    fi
}