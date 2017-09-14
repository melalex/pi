class Dish {

    constructor(name, description, nameLayout, descriptionLayout) {
        this.name = name;
        this.description = description;
        this.parent = parent;
        this.nameLayout = nameLayout;
        this.descriptionLayout = descriptionLayout;

        this.showDescription = this.showDescription.bind(this);
        this.render = this.render.bind(this);
    }

    render() {
        console.log("Dish render call for " + this.name);

        $("<button/>")
            .attr("type", "button")
            .addClass("btn btn-secondary")
            .click(this.showDescription)
            .text(this.name)
            .appendTo(this.nameLayout);
    }

    showDescription() {
        console.log("Dish showDescription call");

        $(this.descriptionLayout).empty();

        $("<p/>")
            .text(this.description)
            .appendTo(this.descriptionLayout)
    }
}