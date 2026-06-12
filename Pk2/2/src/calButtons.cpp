#include "./Calculator.cpp"
#include "./calText.cpp"
#include <QGridLayout>
#include <QPushButton>
#include <iostream>
#include <qgridlayout.h>
#include <qobject.h>
#include <qpushbutton.h>

class calButtons : public QPushButton {

private:
  QPushButton *buttons[21];
  calText *text;
  QString expresstion;
  double lastAnswer = 0.0;

  void initButton(QPushButton *button, QString buttonName) {
    button->setText(buttonName);
    if (buttonName == "Ans") {
      connect(button, &QPushButton::pressed, [=]() {
        text->addInput(buttonName);
        expresstion += QString::number(lastAnswer);
      });

    } else
      connect(button, &QPushButton::pressed, [=]() {
        text->addInput(buttonName);
        expresstion += buttonName.toStdString();
      });
  }

public:
  calButtons(QWidget *parent, QGridLayout *gridLayout, calText *text)
      : QPushButton(parent) {

    this->text = text;

    for (int i = 0; i < 21; i++) {
      buttons[i] = new QPushButton(this);
      buttons[i]->setFixedSize(60, 75);
      buttons[i]->setStyleSheet("background-color: rgb(38, 107, 128);"
                                "border-radius: 10px; "
                                "color: white;");

      if (i < 10) {
        initButton(buttons[i], QString::number(i));
      }

      else if (i == 10) {
        initButton(buttons[i], ".");
      }

      else if (i == 11) {
        initButton(buttons[i], "Ans");
      }

      else if (i == 12) {
        initButton(buttons[i], "+");
      }

      else if (i == 13) {
        initButton(buttons[i], "*");
      }

      else if (i == 14) {
        initButton(buttons[i], "-");
      }

      else if (i == 15) {
        initButton(buttons[i], "/");
      }

      else if (i == 16) {
        gridLayout->addWidget(buttons[i], 2, 4, 1, 2);
        buttons[i]->setText("=");
        connect(buttons[i], &QPushButton::pressed,
                [=]() { // TODO
                  std::cout << expresstion.toStdString() << '\n';
                  Calculator calc;
                  double ergebnis = calc.calculate(expresstion.toStdString());
                  lastAnswer = ergebnis;
                  text->setResult(QString::number(ergebnis));
                  expresstion = "";
//                  text->setText(QString::number(ergebnis));
                });
      }

      else if (i == 17) {
        initButton(buttons[i], "(");
      }

      else if (i == 18) {
        initButton(buttons[i], ")");
      }

      else if (i == 19) {
        buttons[i]->setText("C");
        connect(buttons[i], &QPushButton::pressed,
                [=]() { // TODO
                  text->setResult("");
                  expresstion = "";
                  text->setText(expresstion);
                });
 
      }

      else if (i == 20) {
        buttons[i]->setText("<=");
        connect(buttons[i], &QPushButton::pressed,
                [=]() { // TODO
                  expresstion.removeLast();
                  text->setText(expresstion);
                });
      }

      if (i < 12)
        gridLayout->addWidget(buttons[i], i / 4, i % 4);

      else if (i < 16)
        gridLayout->addWidget(buttons[i], (i - 12) / 2, (i % 2) + 4);

      else if (i < 19)
        gridLayout->addWidget(buttons[i], (i-16) / 2, 6);

      else if (i < 21)
        gridLayout->addWidget(buttons[i], 2, 6 - (i % 2));
 
    }
  }
};
