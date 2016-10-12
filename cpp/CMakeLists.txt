cmake_minimum_required(VERSION 3.6)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(CALCULATOR_SOURCE_FILES calculator/main.cpp calculator/Token.cpp calculator/Token.h calculator/main.cpp calculator/Lexer.cpp calculator/Lexer.h)
set(TEMPLATE_SOURCE_FILES template/main.cpp)
set(HELLOWORLD_SOURCE_FILES aizu/hello_world.cpp)
set(XCUBIC_SOURCE_FILES aizu/x_cubic.cpp)
add_executable(calculator ${CALCULATOR_SOURCE_FILES})
add_executable(template ${TEMPLATE_SOURCE_FILES})
add_executable(hello_world ${HELLOWORLD_SOURCE_FILES})
add_executable(xcubic ${XCUBIC_SOURCE_FILES})
