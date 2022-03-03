package fr.charlotte.libreofficewakatime.comp.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import fr.charlotte.libreofficewakatime.comp.tests.base.UnoSuite;
import fr.charlotte.libreofficewakatime.comp.tests.uno.WriterTest;

@RunWith(UnoSuite.class)
@SuiteClasses({WriterTest.class})
public class UnoTests {

}
