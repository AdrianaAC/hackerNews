import React, { Component } from "react";
import "./App.css";

const list = [
  {
    title: "React",
    url: "https://facebook.github.io/react/",
    author: "Jordan Walke",
    num_comments: 3,
    points: 4,
    objectID: 0,
  },
  {
    title: "Redux",
    url: "https://github.com/reactjs/redux",
    author: "Dan Abramov, Andrew Clark",
    num_comments: 2,
    points: 5,
    objectID: 1,
  },
];

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      list,
    };
    this.onDismiss = this.onDismiss.bind(this);
  }
  onDismiss(id) {
    // const isNotId = (item) => item.objectID !== id;
    // const updatedList = this.state.filter(isNotId);

    const updatedList = this.state.list.filter((item) => item.objectID !== id);
    this.setState({list: updatedList});
  }

  render() {
    return (
      <div className="App">
        {this.state.list.map((item) => (
          <div key={item.objectID}>
            <ul>
              <span>
                <a href={item.url}>{item.title}</a>
              </span>
              <li>{item.author}</li>
              <li>{item.num_comments}</li>
              <li>{item.points}</li>
            </ul>
            <button onClick={() => this.onDismiss(item.objectID)}>
              Dismiss
            </button>
          </div>
        ))}
      </div>
    );
  }
}

export default App;
