import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.{WebBrowser}
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

class MainTest extends FeatureSpec with GivenWhenThen with Matchers with WebBrowser {
  implicit val webDriver: WebDriver = new HtmlUnitDriver
  val host = "https://www.sony.com/search?query="
  info("Enter text to search Bar")
  feature("Test Search Bar") {
    scenario("Open page and enter a product name to search bar") {
      Given("Page is opened with url "+host)
      go to (host)
      pageTitle should be("Search Results | Sony US")
      Then("Entered Text to search bar")
      textField("query").value = "walkman"
      When("Entered text is correct on search bar")
      textField("query").value should be ("walkman")
    }
  }
  info("Check search results displayed")
  feature("Check Searh Results") {
    scenario("Click to searh button and chack the results") {
      Given("Click to search button")
      submit()
      Then("Check result are displayed")
      val eles: Iterator[Element] = findAll(className("results-p"))
      for (e <- eles) {
        e should be('displayed)
      }
    }
  }





//    go to (host)
//  pageTitle should be("Search Results | Sony US")
//  println(pageTitle)
//  textField("query").value = "walkman"
//
//  println(textField("query").value)
//  submit()
//  println(currentUrl)
//  val eles: Iterator[Element] = findAll(className("results-p"))
//  for (e <- eles){
//    e should be ('displayed)
//  }

}
