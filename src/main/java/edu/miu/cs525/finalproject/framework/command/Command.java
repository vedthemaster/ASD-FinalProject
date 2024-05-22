package edu.miu.cs525.finalproject.framework.command;

public interface Command {

    void execute(Object... args) throws Exception;
}
