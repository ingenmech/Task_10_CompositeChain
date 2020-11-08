package by.epam.evm.text.data.parser;

import by.epam.evm.text.model.Component;

public interface Parser {
    Component parse(String text);
}
