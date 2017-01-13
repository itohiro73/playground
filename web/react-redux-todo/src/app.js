import React from 'react';
import { render } from 'react-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import reducer from './reducer';
import { TodoList } from './containers';

// import { List, Map } from 'immutable';
//
//
// const dummyTodos = List([
//     Map({ id: 0, isDone: true,  text: 'Learn Spring Boot' }),
//     Map({ id: 1, isDone: false, text: 'Learn React/Redux' }),
//     Map({ id: 2, isDone: false, text: 'Implement Spring Boot App' }),
//     Map({ id: 3, isDone: false, text: 'Implement React/Redux App' })
// ]);

const store = createStore(reducer);

render(
    <Provider store={store}>
        <TodoList />
    </Provider>,
    document.getElementById('app')
);