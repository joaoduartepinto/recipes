import React from 'react';
import {FooterContainer, FooterRights, FooterDiv} from "./FooterElements";

const Footer = () => {

    return (
        <>
            <FooterContainer>
                <FooterDiv>
                    <FooterRights>
                        João Pinto © {new Date().getFullYear()}
                    </FooterRights>
                </FooterDiv>
            </FooterContainer>
        </>
    )
}

export default Footer;