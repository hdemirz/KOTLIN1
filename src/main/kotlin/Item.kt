package org.example

import java.util.*

// Item class with name and price properties
open class Item(val name: String, val price: Double)

// Food class extending Item with weight property
class Food(name: String, price: Double, val weight: String) : Item(name, price)

// Cloth class extending Item with type property
class Cloth(name: String, price: Double, val type: String) : Item(name, price)

// ShoppingList class
class ShoppingList {
    private val itemList = mutableListOf<Item>()

    // Function to add item to the list
    fun addItem(item: Item) {
        itemList.add(item)
        println("Item added successfully!")
    }

    // Function to display items in the list
    fun displayItems() {
        for ((index, item) in itemList.withIndex()) {
            println("${index + 1}. ${item.name} - $${item.price}")
            when (item) {
                is Food -> println("   Weight: ${item.weight}")
                is Cloth -> println("   Type: ${item.type}")
            }
        }
    }

    // Function to delete item from the list
    fun deleteItem(index: Int) {
        if (index >= 0 && index < itemList.size) {
            itemList.removeAt(index)
            println("Item deleted successfully!")
        } else {
            println("Invalid item index!")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val shoppingList = ShoppingList()

    var option: Int
    do {
        println("\nShopping List App")
        println("1) Add Item")
        println("2) Display Item")
        println("3) Delete Item")
        println("4) Exit")
        print("Enter your choice: ")

        option = scanner.nextInt()

        when (option) {
            1 -> {
                println("Select item type:")
                println("1. Food")
                println("2. Cloth")
                print("Enter item type: ")
                val itemType = scanner.nextInt()
                scanner.nextLine() // Consume newline character

                when (itemType) {
                    1 -> {
                        print("Enter food name: ")
                        val name = scanner.nextLine()
                        print("Enter food price: ")
                        val price = scanner.nextDouble()
                        scanner.nextLine() // Consume newline character
                        print("Enter food weight: ")
                        val weight = scanner.nextLine()
                        shoppingList.addItem(Food(name, price, weight))
                    }
                    2 -> {
                        print("Enter cloth name: ")
                        val name = scanner.nextLine()
                        print("Enter cloth price: ")
                        val price = scanner.nextDouble()
                        scanner.nextLine() // Consume newline character
                        print("Enter cloth type: ")
                        val type = scanner.nextLine()
                        shoppingList.addItem(Cloth(name, price, type))
                    }
                    else -> println("Invalid item type!")
                }
            }
            2 -> shoppingList.displayItems()
            3 -> {
                print("Enter item index to delete: ")
                val index = scanner.nextInt()
                shoppingList.deleteItem(index - 1)
            }
            4 -> println("Exiting...")
            else -> println("Invalid option! Please try again.")
        }
    } while(option!=4)
}