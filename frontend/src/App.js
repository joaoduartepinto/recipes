import styled from 'styled-components';
import Routes from "./Routes";

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
                <Routes/>
            </Body>
        </>
    );
}

export default App;
