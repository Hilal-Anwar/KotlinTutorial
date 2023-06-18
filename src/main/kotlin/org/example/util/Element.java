package org.example.util;

public record Element<T extends Number>(T value, int index) {
}