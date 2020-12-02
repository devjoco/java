/**
 * Chapter 9 Short answer questions.
 * 1.) What is an "is-a" relationship?
 *
 *      An "is-a" relationship specifies that one class is a subclass of
 *      another class. This allows the subclass to inherit all of the members
 *      of the superclass, while also adding more specific methods and fields. 
 *
 *
 * 2.) A program uses two classes: Animal and Dog. Which class is the 
 * superclass and which is the subclass?
 *
 *      The Animal class would be the superclass and the Dog class would be the
 *      subclass. 
 *
 *
 * 3.) What is the superclass and what is the sublcass in the following line? 
 * public class Pet extends Dog
 *
 *      Pet is the subclass and Dog is the superclass.
 *
 *
 * 4.) What is the difference between a protected class emmber and a private
 * class member?
 *      
 *      Private class members are only accessible by the class itself, and this
 *      class must provide public methods in order to allow subclasses or other
 *      classes that do not inherit from it to access these members. 
 *
 *      Protected class members are accessible by subclasses and classes in the
 *      same package.
 *
 *
 * 5.) Can a subclass ever directly access the private members of its
 * superclass?
 *
 *      No, a subclass must go through the superclass' public mutator and
 *      getter methods in order to access the private members.
 *
 *
 * 6.) Which constructor is called first, that of the sublcass or the
 * superclass?
 *
 *      The technically correct answer is that the subclass' constructor is
 *      called first; but the first thing that constructor does is call the
 *      superclass' constructor. This has the affect of all of the superclass'
 *      constructor's behavior taking place before that of the subclass'
 *      constructor, so it is as if the superclass' constructor is called
 *      first.
 *
 *
 * 7.) What is the difference between overriding a superclass method and
 * overloading a superclass method?
 *
 *      Overriding a superclass method is creating a new definition in a
 *      subclass with the same method signature of that which is present in the
 *      superclass. This removes the ability for you to access the superclass'
 *      method that has been overridden without using the 'super' reference. 
 *
 *      Overloading a superclass invovles creating a new method with the same
 *      name, but a different signature, as a method that exists in the
 *      superclass. This will not shadow the method found in the superclass,
 *      and both are accessible by providing a different set of parameters to
 *      the same-named method.
 *
 *
 * 8.) Reference variables can be polymorphic. What does this mean?
 *
 *      This means that the reference variables can hold different data types;
 *      specifically, they can hold references to data types that have an
 *      "is-a" relationship with the originally-defined datatype for the
 *      reference variable. Using these can allow the same varaible to
 *      hold a reference to two different classes, as long as they both share a
 *      common superclass.
 *
 *
 * 9.) When does dynamic binding take place?
 *
 *      Dynamic binding takes place at runtime, as opposed to at compile time.
 *
 *
 * 10.) What is an abstract method?
 *
 *      This is a method that must be overridden in a subclass. It provides the
 *      framework, or expected signature of the method that is expected, but
 *      allows the subclass to define the exact behavior of the method.
 *
 *
 * 11.) What is an abstract class?
 *
 *      An abstract class is one with abstract methods. It cannot be
 *      instantiated, but instead acts as a framework, or template for
 *      subclasses.
 *
 *
 * 12.) What are the differences between an abstract class and an interface?
 *
 *      An abstract class can have some non-abstract methods, as well as
 *      non-static and non-final fields. An abstract class can be 'extended,'
 *      while an interface must be 'implemented.' A class can implement many
 *      different interfaces, but can only extend from one abstract (or
 *      non-abstract) class. 
 *
 */
