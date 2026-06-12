#include <QTextEdit>
#include <QScrollBar>
#include <qtextcursor.h>

class calText : public QTextEdit {
private:
  double lastAnswer;
  bool freshResult = false;

public:
    calText(QWidget *parent = nullptr) : QTextEdit(parent),lastAnswer(0.0) {
        setReadOnly(true);
        setFixedHeight(150);
        setAlignment(Qt::AlignRight | Qt::AlignBottom);

        setStyleSheet("   background-color: rgba(64, 64, 115, 60%);"
                      "   border: 2px solid rgb(43, 103, 128);"
                      "   border-radius: 15px;"
                      "   font-size: 32px;"
                      "   padding: 10px;"
                      "   color: #FFFFFF;" /* Pure White */
        );

        verticalScrollBar()->setStyleSheet("width: 0px;");
        setTextColor(Qt::white);
    }

    void addInput(const QString &input) {

        if(freshResult && (input == "Ans" || input[0].isDigit() || input == ".")){
            clearDisplay();
            freshResult = false;
        } else {
            freshResult = false;
        }
        
        QString current = toPlainText();
        setPlainText(current + input);
        moveCursor(QTextCursor::End);
    }
    
    void setResult(const QString &result){
        setPlainText(result);
        lastAnswer = result.toDouble();
        freshResult = true;
        moveCursor(QTextCursor::End);
    }

    void clearDisplay() {
        clear();
        freshResult = false;
    }

    double getLastAnswer() const { return lastAnswer; }

    QString getCurrentText() const {
        return toPlainText();
    }
};
