#include <QApplication>
#include "./calWindow.cpp"

int main(int argc, char **argv) {
  QApplication app(argc, argv);

  calWindow win;

  win.show();

  return app.exec();
}
