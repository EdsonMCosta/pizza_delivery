function StepsHeader() {
    return (
        <header className="orders-steps-container">
            <div className="orders-steps-content">
                <h1 className="steps-title">
                    FOLLOW <br /> THE STEPS
                </h1>
                <ul className="steps-items">
                    <li>
                        <span className="steps-number">1</span>
                        Choose the products and your location.
                    </li>
                    <li>
                        <span className="steps-number">2</span>
                        After that click on <strong>"SEND ORDER"</strong>.
                    </li>
                </ul>

            </div>
        </header>
    )
}

export default StepsHeader;