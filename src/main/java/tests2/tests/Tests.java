package tests2.tests;// Generated by Selenium IDE


import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import tests2.models.Account;
import tests2.models.Mail;
import tests2.models.Page;
import tests2.models.SuperMail;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Tests extends AuthBase {


    public Tests() throws IOException, SAXException, ParserConfigurationException { }

    @Test
    public void sendMailToDrafts() throws JAXBException, FileNotFoundException {

        applicationManager.getClickerHelper().openMenu();
        applicationManager.getClickerHelper().clickOnNewMailButton();
        Mail mail = getFromXmlFile("C:\\Users\\Ken\\IdeaProjects\\Schooool\\mail.xml");
        applicationManager.getMailCreationHelper().createNewMail(mail);
        applicationManager.getClickerHelper().clickSaveButton();
        applicationManager.getClickerHelper().clickOnDraftsByLinkAfterSaving();
        applicationManager.getClickerHelper().clickOnFirstRow();
        Mail mailData = applicationManager.getMailCreationHelper().getCreatedMailData();
        //в черновике должны совпадать и получатель и текст
        Assert.assertEquals(mail, mailData);
    }

    private Mail getFromXmlFile(String filePath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Mail.class);
        return (Mail) context.createUnmarshaller()
                .unmarshal(new FileReader(filePath));
    }

    @Test
    public void sendFullMailWithCopyToMe() {
        applicationManager.getClickerHelper().clickOnLogoIcon();
        applicationManager.getClickerHelper().clickOnNotes();
        applicationManager.getClickerHelper().clickOnCreateNewNoteIcon();
        SuperMail mailExtended = new SuperMail("si1x@bk.ru", "Супер текст Добавим ещё немного Ну всё хватит",
                "si1x@bk.ru", "Очень интересная тема");
        applicationManager.getMailCreationHelper().fillTheMailWithParameters(mailExtended);
        applicationManager.getClickerHelper().clickOnSendButton();
        applicationManager.getPageHelper().refreshPage();
        applicationManager.getClickerHelper().clickOnFirstRow();
        SuperMail mailExtendedData = applicationManager.getMailCreationHelper().getExtendedMailData();
        //необходимо проверить совпадение текста и темы письма, письмо приходит нам
        // (не нужно заходить с другого аккаунта и проверять получателя)
        Assert.assertEquals(mailExtended.getSubject(), mailExtendedData.getSubject());
        Assert.assertEquals(mailExtended.getText(), mailExtendedData.getText());
    }

    @Test
    public void deleteFirstIncomingMessage() {
        applicationManager.getClickerHelper().clickOnLogoIcon();
        applicationManager.getClickerHelper().clickOnIncoming();
        applicationManager.getClickerHelper().clickOnFirstRow();
        //забираем данные письма которое мы собираемся удалить
        SuperMail firstMailData = applicationManager.getMailCreationHelper().getExtendedMailData();
        applicationManager.getClickerHelper().deleteCurrentMessage();
        applicationManager.getClickerHelper().clickOnFirstRow();
        //забираем данные письма которое теперь лежит первым в списке
        SuperMail secondMailData = applicationManager.getMailCreationHelper().getExtendedMailData();
        //проверяем что данные писем не совпадают
        Assert.assertNotEquals(firstMailData, secondMailData);
    }


}
