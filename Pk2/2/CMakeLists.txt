cmake_minimum_required(VERSION 3.16)
project(MeinQtProjekt VERSION 1.0 LANGUAGES CXX)

# WICHTIG für Neovim/LSP: Erzeugt compile_commands.json
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)

# C++ Standard festlegen
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Qt-Magie aktivieren (MOC, UI, Resources)
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTORCC ON)

# Qt6 Bibliotheken suchen
find_package(Qt6 REQUIRED COMPONENTS Widgets)

# Das Programm erstellen
# Falls deine main.cpp direkt im Ordner liegt, entferne "src/"
add_executable(mein_projekt 
    src/main.cpp
)

# Qt-Module verlinken
target_link_libraries(mein_projekt PRIVATE Qt6::Widgets)
