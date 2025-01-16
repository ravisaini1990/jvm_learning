package design_pattern.statergy;

interface ICompressionStrategy {
    void compress(String sourceFile, String destinationFile);
}


/**
 * Strategy Design pattern , multiple algorithm interchangeable at runtime
 */
public class CompressionStrategy {
    ICompressionStrategy iCompressionStrategy;

    CompressionStrategy(ICompressionStrategy iCompressionStrategy) {
        this.iCompressionStrategy = iCompressionStrategy;
    }

    public void compressFile(String sourceFile, String destinationFile) {
        if (iCompressionStrategy != null) {
            iCompressionStrategy.compress(sourceFile, destinationFile);
        } else {
            System.out.println("No compression strategy selected.");
        }
    }

    public static void main(String[] args) {
        final String sourceFileName = "abc";
        final String destinationFileName = "CompressFile";

        //Zip Compressed
        CompressionStrategy compressionStrategy = new CompressionStrategy(new ZipCompression());
        compressionStrategy.compressFile(sourceFileName, destinationFileName);

        //Jar Compressed
        CompressionStrategy jarCompressionStrategy = new CompressionStrategy(new JarCompression());
        jarCompressionStrategy.compressFile(sourceFileName, destinationFileName);

        //Rar Compressed
        CompressionStrategy rarCompressionStrategy = new CompressionStrategy(new RarCompression());
        rarCompressionStrategy.compressFile(sourceFileName, destinationFileName);
    }
}


class ZipCompression implements ICompressionStrategy {

    @Override
    public void compress(String sourceFile, String destinationFile) {
        System.out.println("Zip Compress ::" + sourceFile + "::: " + destinationFile);
    }
}

class JarCompression implements ICompressionStrategy {

    @Override
    public void compress(String sourceFile, String destinationFile) {
        System.out.println("Jar Compress ::" + sourceFile + "::: " + destinationFile);
    }
}

class RarCompression implements ICompressionStrategy {

    @Override
    public void compress(String sourceFile, String destinationFile) {
        System.out.println("Rar Compress ::" + sourceFile + "::: " + destinationFile);
    }
}
