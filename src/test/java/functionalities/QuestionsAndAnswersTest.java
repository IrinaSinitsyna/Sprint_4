package functionalities;

import common.CommonTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuestionsAndAnswersTest extends CommonTest {

    private final By questionButton;
    private final By answerText;

    public QuestionsAndAnswersTest(By questionButton, By answerText) {
        this.questionButton = questionButton;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getQuestionsAndAnswers() {
        return Arrays.asList(new Object[][]{
                {HomePage.HOW_MUCH_DOES_IT_COST_AND_HOW_TO_PAY_BUTTON, HomePage.HOW_MUCH_DOES_IT_COST_AND_HOW_TO_PAY_ANSWER},
                {HomePage.SEVERAL_SCOOTERS_POSSIBLE_BUTTON, HomePage.SEVERAL_SCOOTERS_POSSIBLE_ANSWER},
                {HomePage.RENTAL_TIME_CALCULATION_BUTTON, HomePage.RENTAL_TIME_CALCULATION_ANSWER},
                {HomePage.ORDER_A_SCOOTER_FOR_TODAY_BUTTON, HomePage.ORDER_A_SCOOTER_FOR_TODAY_ANSWER},
                {HomePage.EXTEND_THE_ORDER_OR_RETURN_EARLIER_BUTTON, HomePage.EXTEND_THE_ORDER_OR_RETURN_EARLIER_ANSWER},
                {HomePage.CHARGING_UNIT_WITH_SCOOTER_BUTTON, HomePage.CHARGING_UNIT_WITH_SCOOTER_ANSWER},
                {HomePage.ORDER_CANCELLATION_BUTTON, HomePage.ORDER_CANCELLATION_ANSWER},
                {HomePage.BRING_IT_BEYOND_THE_MRR_BUTTON, HomePage.BRING_IT_BEYOND_THE_MRR_ANSWER}
        });
    }

    @Before
    @Override
    public void setUp() {
        setBrowserType("chrome");
        super.setUp();
        //Скролл страницы до конца
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void QuestionAndAnswerCheckingTheTextDisplay() {
        homePage.checkQuestionAndAnswer(questionButton, answerText);
    }
}

