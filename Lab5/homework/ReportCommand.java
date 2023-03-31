package homework;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.awt.*;
import java.io.*;

/**
 * clasa ReportCommand se foloseste de Velocity si template ul de HTML din package-ul homework al proiectului pentru a realiza
 * un raport referitor la catalogul nostru si a il deschide
 */
public class ReportCommand implements Command {

    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute()  {


            Velocity.init();
            Template template = Velocity.getTemplate("./src/main/java/homework/HTMLreport.vm");

            VelocityContext context = new VelocityContext();
            context.internalPut("documents", catalog.getDocs());
            context.internalPut("catalog", catalog);
            Writer writer = new StringWriter();
            template.merge(context, writer);
            String report = writer.toString();

            try {
            File reportFile = File.createTempFile("report", ".html");
            FileWriter fileWriter = new FileWriter(reportFile);
            fileWriter.write(report);
            fileWriter.close();
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
