#include "./calButtons.cpp"

class calWindow : public QWidget {
private:
  calButtons *buttons;
  calText *display;

public:
  calWindow() {
    setFixedSize(485, 435);
    setAttribute(Qt::WA_TranslucentBackground);

    setStyleSheet("background-color: rgba(35, 35, 60, 70%);"
                  "border-radius: 0px;");

    QGridLayout *gridLayout = new QGridLayout(this);
    QGridLayout *buttonGrid = new QGridLayout();
    QGridLayout *textGrid   = new QGridLayout();

    display = new calText();
    textGrid->addWidget(display, 0, 0, 1, 6);

    //    gridLayout->setColumnStretch(6, 5);
    gridLayout->setContentsMargins(15, 15, 15, 15);
    gridLayout->setSpacing(10);
    gridLayout->setAlignment(Qt::AlignLeft | Qt::AlignTop);
    buttons = new calButtons(this, buttonGrid, display);
    buttons->setGeometry(0, 0, 485, 450);

    gridLayout->addLayout(textGrid, 0, 0);
    gridLayout->addLayout(buttonGrid, 1, 0);
  }
};
