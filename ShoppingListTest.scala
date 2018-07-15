under project strcture > src > test > scala >   
==========================================

import org.scalatest.Matchers
import org.scalatest.mock.MockitoSugar
import org.scalatest.path.FunSpecLike

class ShoppingListTest
  extends FunSpecLike
    with Matchers
    with MockitoSugar {


  describe("Shopping Cart Functionality") {
    val cart = ShoppingList();
    /* Test */
    describe("Contains only Cola") {
      cart.Add("Cola")

      it("Contains Cola") {
        cart.items should have length 2
        cart.items should contain (ListOfItem(0.50, "Cola"))
      }

      it("price 50p") {
        cart.total should be (0.50)
      }
    }
    /* Test 2 */
    describe("Contains only Coffee") {
      cart.Add("Coffee")

      it("Contains only Coffee") {
        cart.items should have length 1
        cart.items should contain (ListOfItem(1.00, "Coffee"))
      }

      it("Cost £1.00") {
        cart.total should be (1.00)
      }
    }
    /* Test 3 */
    describe("Cola,Coffee and Cheese Sandwich - contains any one food - 10% of service charge") {
      cart.Add("Cola")
      cart.Add("Coffee")
      cart.Add("Cheese Sandwich")

      it("costs £3.50") {
        cart.total shouldNot be (3.50 + 3.50*0.1)
      }
    }

    /* Test 4 */
    describe("Cola,Coffee and Steak Sandwich - contains any one hot food - 20% of service charge") {
      cart.Add("Cola")
      cart.Add("Coffee")
      cart.Add("Steak Sandwich")

      it("costs £6.00") {
        cart.total shouldNot be (6.00 + 6.00*0.2)
      }
    }
    /* Test 5 */
    describe("add any other item ABC"){
      it("throws a  Error NoSuchElementException") {
        intercept[NoSuchElementException] {
          cart.Add("ABC")
        }
      }
    }
  }
}
