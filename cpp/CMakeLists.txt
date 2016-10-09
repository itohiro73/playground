cmake_minimum_required(VERSION 3.6)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(CALCULATOR_SOURCE_FILES calculator/main.cpp)
set(TEMPLATE_SOURCE_FILES template/main.cpp)
add_executable(calculator ${CALCULATOR_SOURCE_FILES})
add_executable(template ${TEMPLATE_SOURCE_FILES})
