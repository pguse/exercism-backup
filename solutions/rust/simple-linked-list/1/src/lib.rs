use std::iter::FromIterator;

pub struct Node<T> {
    data: T,
    next: Option<Box<Node<T>>>,
}
pub struct SimpleLinkedList<T> {
    head: Option<Box<Node<T>>>,
}

impl<T> SimpleLinkedList<T> {
    pub fn new() -> Self {
        SimpleLinkedList{head: None}
    }

    pub fn is_empty(&self) -> bool {
        match self.head {
            None => true,
            _ => false,
        }
    }

    pub fn len(&self) -> usize {
        let mut list = &self.head;
        let mut count = 0;

        while let Some(ref rest) = *list {
            count += 1;
            list = &rest.next;
        }

        count
    }

    pub fn push(&mut self, element: T) {
        let new_node = Box::new(Node {data: element, next: self.head.take()});
        self.head = Some(new_node)
    }

    pub fn pop(&mut self) -> Option<T> {
        self.head.take().map(|node| {self.head = node.next; node.data})
    }

    pub fn peek(&self) -> Option<&T> {
        self.head.as_ref().map(|node| {&node.data})
    }

    #[must_use]
    pub fn rev(self) -> SimpleLinkedList<T> {
        let mut linked_list = SimpleLinkedList::new();
        let mut ptr = self;
        
        while let Some(x) = ptr.pop() {
            linked_list.push(x);
        }
        linked_list
    }
}

impl<T> FromIterator<T> for SimpleLinkedList<T> {
    fn from_iter<I: IntoIterator<Item = T>>(iter: I) -> Self {
        let mut list = Self::new();
        for item in iter {
            list.push(item);
        }
        list
    }
}

// In general, it would be preferable to implement IntoIterator for SimpleLinkedList<T>
// instead of implementing an explicit conversion to a vector. This is because, together,
// FromIterator and IntoIterator enable conversion between arbitrary collections.
// Given that implementation, converting to a vector is trivial:
//
// let vec: Vec<_> = simple_linked_list.into_iter().collect();
//
// The reason this exercise's API includes an explicit conversion to Vec<T> instead
// of IntoIterator is that implementing that interface is fairly complicated, and
// demands more of the student than we expect at this point in the track.

impl<T> From<SimpleLinkedList<T>> for Vec<T> {
    fn from(mut linked_list: SimpleLinkedList<T>) -> Vec<T> {
        let mut vec_list: Vec<T> = Vec::new();

        while let Some(data) = linked_list.pop() {
            vec_list.push(data);
        }
        vec_list.reverse();
        vec_list
    }
}