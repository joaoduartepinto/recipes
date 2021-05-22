import Footer from "./Footer";
import styled from 'styled-components';

const Body = styled.body`
  width: 100vw;
  height: 100%;
  margin: 0;
  padding: 0;
`


function App() {

    return (
        <>
            <Body>
                {/*<h1>Hello</h1>*/}
                {/*<Table/>*/}
                <Footer/>
            </Body>
        </>
    );
}

export default App;
